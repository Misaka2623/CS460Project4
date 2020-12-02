package main;

import bean.Address;
import bean.Member;
import bean.Person;
import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import dao.PersonDao;
import dao.PersonDaoImpl;
import util.Encryption;
import util.Gender;
import view.TextView;
import view.View;

import java.sql.Date;
import java.util.List;

public class Main {
    private static final View view = new TextView();
    private static final AddressDao addressDao = new AddressDaoImpl();
    private static final MemberDao memberDao = new MemberDaoImpl();
    private static final PersonDao personDao = new PersonDaoImpl();

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
            shopping();
        } else {
            view.showSignInFailView();
            signInOrUp();
        }
    }

    private static void signUp() {
        view.newPage();
        Member member = new Member();
        member.setUsername(view.requireUsername());
        if (memberDao.containsUsername(member.getUsername())) {
            view.showDuplicateUsernameView();
            signInOrUp();
            return;
        }
        member.setPassword(Encryption.encrypt(view.requirePassword()));
        Person person = new Person();
        person.setFirstName(view.requireFirstName());
        person.setLastName(view.requireLastName());
        person.setGender(view.requireGender());
        person.setBirthday(view.requireBirthday());
        person.setPhone(view.requirePhoneNumber());
        Address address = new Address();
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
        memberDao.insert(member);

        view.showSignUpSuccessView();
        shopping();
    }

    private static void shopping() {
        view.newPage();
        List<Long> shoppingCart = view.showShoppingPage();
        // TODO: 12/1/20
    }
}
