package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@Autowired
	private MemberRepository mr;

	@Autowired
	private PhoneRepository pr;


	@GetMapping(path="/init")
	public @ResponseBody List<Member> init() {
//		Member first = new Member("Jung"); // (1)
//		first.addPhone(new Phone("010-XXXX-XXXX"));
//		first.addPhone(new Phone("010-YYYY-YYYY"));
//
//		Member second = new Member("Dong");
//		second.addPhone(new Phone("010-ZZZZ-ZZZZ"));
//
//		Member third = new Member("Min"); // (2)
//
//		mr.save(first); // (3)
//		mr.save(second);
//		mr.save(third); // (4)

		List<Member> list = mr.findAll(); // (5)
		return list;
	}


	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
