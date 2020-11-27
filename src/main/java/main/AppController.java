package main;

import bean.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import util.Encryption;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Controller
public class AppController {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

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
        return "returnIndex";
    }

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
