package main;

import bean.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Controller
public class AppController {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/register")
    public String addMember(@ModelAttribute Member member) {
        jdbcTemplate.update("INSERT INTO \"member\" VALUES (?,?,?,?,?,?,?,?,?)", member.getMemberId(),
                member.getUsername(), member.getPassword(), member.getFirstName(), member.getLastName(),
                member.getBirthday(), member.getAddress(), member.getPhone(), 0);
        return "returnIndex";
    }

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
