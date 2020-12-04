package main;

import bean.Address;
import bean.Member;
import bean.Person;
import bean.Product;
import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.SaleDao;
import dao.SaleDaoImpl;
import util.Encryption;
import util.Gender;
import view.TextView;
import view.View;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final View view = new TextView();
    private static final AddressDao addressDao = new AddressDaoImpl();
    private static final MemberDao memberDao = new MemberDaoImpl();
    private static final PersonDao personDao = new PersonDaoImpl();
    private static final ProductDao productDao = new ProductDaoImpl();
    private static final SaleDao saleDao = new SaleDaoImpl();
    private static long userId;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        view.newPage();
        view.greet();
        recognizeIdentity();
    }

    private static void recognizeIdentity() {
        view.newPage();
        int option = view.showIdentityView();
        switch (option) {
            case 0:
                view.newPage();
                view.exit();
                return;
            case 1:
                signInOrUp();
                break;
            case 2:
                // TODO: 12/1/20
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private static void signInOrUp() {
        view.newPage();
        int option = view.showSignView();
        switch (option) {
            case 0:
                return;
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private static void signIn() {
        view.newPage();
        String username = view.requireUsername();
        String password = view.requirePassword();
        boolean valid = memberDao.checkUsernameAndPassword(username, Encryption.encrypt(password));
        if (valid) {
            view.showSignInSuccessView();
            userId = memberDao.getMemberIdByUsername(username);
            shopping(username);
        } else {
            view.showSignInFailView();
            signInOrUp();
        }
    }

    private static void signUp() {
        view.newPage();

        Member member = new Member();
        Person person = new Person();
        Address address = new Address();

        member.setUsername(view.requireUsername());
        if (memberDao.containsUsername(member.getUsername())) {
            view.showDuplicateUsernameView();
            signInOrUp();
            return;
        }
        member.setPassword(Encryption.encrypt(view.requirePassword()));
        person.setFirstName(view.requireFirstName());
        person.setLastName(view.requireLastName());
        person.setGender(view.requireGender());
        person.setBirthday(view.requireBirthday());
        person.setPhone(view.requirePhoneNumber());
        address.setLine1(view.requireLine1());
        address.setLine2(view.requireLine2());
        address.setLine3(view.requireLine3());
        address.setCity(view.requireCity());
        address.setState(view.requireState());
        address.setPostalCode(view.requirePostalCode());

        long addressId = addressDao.insert(address);
        person.setAddressId(addressId);

        long personId = personDao.insert(person);
        member.setPersonId(personId);

        userId = memberDao.insert(member);

        view.showSignUpSuccessView();

        shopping(member.getUsername());
    }

    private static void shopping(String username) {
        view.newPage();
        view.showGreet(username);
        Map<Product, Integer> products = productDao.getAllProducts();
        Map<Long, Integer> cart = new HashMap<>();
        addProduct(products, cart);
        String paymentMethod = view.requirePaymentMethod();
        long price = saleDao.insert(userId, paymentMethod, cart);
    }

    private static void addProduct(Map<Product, Integer> products, Map<Long, Integer> cart) {
        int option = view.showShoppingAction();
        switch (option) {
            case 0:
                return;
            case 1:
                view.showProductList(products);
                break;
            case 2:
                long productId = view.requireProductId();
                int amount = view.requireProductAmount();
                int stock = products.get(new Product(productId));
                if (stock < amount) {
                    view.showAddToCartFailView(productId, stock);
                } else {
                    cart.put(productId, cart.getOrDefault(productId, 0) + amount);
                }
        }
        addProduct(products, cart);
    }
}
