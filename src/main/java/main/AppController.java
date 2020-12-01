package main;

import bean.Member2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import util.IdGenerator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.LinkedList;

@SuppressWarnings("SqlResolve")
@Controller
public class AppController {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/addMember")
    private String memberForm(Model model) {
        model.addAttribute("member2", new Member2());
        return "addMember";
    }

    @PostMapping("/addMember")
    private String addMember(@ModelAttribute Member2 member2) {
        long addressId = insertAddress(member2);
        long personId = insertPerson(member2, addressId);
        insertMember(member2, personId);
        return "products";
    }

    private long insertAddress(Member2 member2) {
        long addressId = IdGenerator.generateAddressId(jdbcTemplate);
        StringBuilder sqlBuilder = new StringBuilder();
        LinkedList<Object> args = new LinkedList<>();
        int count = 0;
        sqlBuilder.append("INSERT INTO \"address\" (\"address_id\", \"line1\"");
        args.add(addressId);
        args.add(member2.getLine1());
        if (member2.getLine2() != null && !"".equals(member2.getLine2())) {
            sqlBuilder.append(", \"line2\"");
            args.add(member2.getLine2());
            count++;
        }
        if (member2.getLine3() != null && !"".equals(member2.getLine3())) {
            sqlBuilder.append(", \"line3\"");
            args.add(member2.getLine3());
            count++;
        }
        sqlBuilder.append(", \"city\", \"state\", \"postal_code\") VALUES (?,?,?,?,?");
        args.add(member2.getCity());
        args.add(member2.getState());
        args.add(member2.getPostalCode());
        for (int i = 0; i < count; i++) {
            sqlBuilder.append(",?");
        }
        sqlBuilder.append(")");
        jdbcTemplate.update(sqlBuilder.toString(), args.toArray());
        return addressId;
    }

    private long insertPerson(Member2 member2, long addressId) {
        long personId = IdGenerator.generatePersonId(jdbcTemplate);
        StringBuilder sqlBuilder = new StringBuilder();
        LinkedList<Object> args = new LinkedList<>();
        int count = 0;
        sqlBuilder.append("INSERT INTO \"person\" (\"person_id\", \"first_name\", \"last_name\", \"gender\"");
        args.add(personId);
        args.add(member2.getFirstName());
        args.add(member2.getLastName());
        args.add(member2.getGender());
        if (member2.getBirthday() != null) {
            sqlBuilder.append(", \"birthday\"");
            args.add(member2.getBirthday());
            count++;
        }
        sqlBuilder.append(", \"address_id\"");
        args.add(addressId);
        if (member2.getPhone() != null && !"".equals(member2.getPhone()) && !"0".equals(member2.getPhone())) {
            sqlBuilder.append(", \"phone\"");
            args.add(member2.getPhone());
            count++;
        }
        sqlBuilder.append(") VALUES (?,?,?,?,?");
        for (int i = 0; i < count; i++) {
            sqlBuilder.append(",?");
        }
        sqlBuilder.append(")");
        jdbcTemplate.update(sqlBuilder.toString(), args.toArray());
        return personId;
    }

    private void insertMember(Member2 member2, long personId) {
        long memberId = IdGenerator.generateMemberId(jdbcTemplate);
        jdbcTemplate.update("INSERT INTO \"member\" VALUES (?,?,?,?,?)",
                memberId, member2.getUsername(), member2.getPassword(), personId, 0);
    }

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
