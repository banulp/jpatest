package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/gd") // This means URL's start with /demo (after Application path)
public class GdController {
	@Autowired
	private ApiRepository ar;

	@Autowired
	private VariableRepository vr;


	@GetMapping(path="/allapi")
	public @ResponseBody List<Api> init() {
		List<Api> list = ar.findAll(); // (5)
		return list;
	}

}
