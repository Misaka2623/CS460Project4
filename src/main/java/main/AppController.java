package main;

import bean.Member;
import bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import util.Encryption;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Controller
public class AppController {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Member member) {
        // TODO: 11/27/20
        return "products";
    }

    @GetMapping("/register")
    public String memberForm(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String addMember(@ModelAttribute Member member) {
        jdbcTemplate.update("INSERT INTO \"member\" VALUES (?,?,?,?,?,?,?,?,?)", member.getMemberId(),
                member.getUsername(), Encryption.encrypt(member.getPassword()), member.getFirstName(), member.getLastName(),
                member.getBirthday(), member.getAddress(), member.getPhone(), 0);
        return "products";
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = jdbcTemplate.query("SELECT * FROM \"product\"", new BeanPropertyRowMapper<>(Product.class));
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/buyProduct")
    public String buyProduct(Model model) {
        // TODO: 11/27/20
        return "returnIndex";
    }

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
