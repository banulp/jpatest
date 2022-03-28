package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/gd") // This means URL's start with /demo (after Application path)
public class GdController {
	@Autowired
	private ApiRepository ar;

	@Autowired
	private VariableRepository vr;


	@GetMapping(path="/allapi")
	public @ResponseBody Flux<Api> init() {
		Flux<Api> list = ar.findAll(); // (5)
		return list;
	}

	@GetMapping(path="/alist")
	public @ResponseBody Flux<Api> alist() {
		return ar.findAll()
				.collectMap(Api::getId)
				.flatMapMany(apis -> vr.findAllWithApis(apis.keySet())
						.bufferUntilChanged(Variable::getApiId)
						.map(variables -> {
							return apis.get(variables.get(0).getApiId()).update(variables);
						})
				);
	}

	@GetMapping(path="/alist/{name}")
	public @ResponseBody Flux<Api> alist(@PathVariable String name) {
		return ar.findByCode(name)
				.log()
//				.collectMap(Api::getId)
//				.flatMapMany(apis -> vr.findAllWithApis(apis.keySet())
//						.bufferUntilChanged(Variable::getApiId)
//						.map(variables -> {
//							return apis.get(variables.get(0).getApiId()).update(variables);
//						})
//				);
				.collectMap(api -> {
					return api.getId();
						}
				)
				.log()
				.flatMapMany(apis ->
						{
							return vr.findAllWithApis(apis.keySet())
									.log()
									.bufferUntilChanged(variable -> {
										return variable.getApiId();
									})
									.log()
									.map(variables -> {
										return apis.get(variables.get(0).getApiId()).update(variables);
									})
									.log();
						}
				)
				.log();
	}

	@GetMapping(path="/allapi/{code}")
	public @ResponseBody Flux<Api> codeApi(@PathVariable String code) {
		Flux<Api> list = ar.findByCode(code); // (5)
		return list;
	}

}
