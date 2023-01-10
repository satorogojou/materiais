package ifrn.pi.materiais.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ifrn.pi.materiais.models.Material;
import ifrn.pi.materiais.repository.MaterialRepository;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialRepository mr;

	@RequestMapping(value="/salvarMaterial", method=RequestMethod.GET)
	public String form() {
		return "material/formMaterial";
	}
	
	@RequestMapping(value="/salvarMaterial", method=RequestMethod.POST)
	public String form(@Valid Material material, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/salvarMaterial";
		}
		mr.save(material);
		attributes.addFlashAttribute("mensagem", "Material salvado com sucesso!");
		return "redirect:/salvarMaterial";
	}
	
	@RequestMapping("/materiais")
	public ModelAndView listarMateriais() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Material> materiais = mr.findAll();
		mv.addObject("materiais", materiais);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesMaterial(@PathVariable("codigo") long codigo) {
		Material material = mr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("material/detalhesMaterial");
		mv.addObject("material", material);
		System.out.println("material" + material);
		return mv;
	}
	
	@RequestMapping("/concluir")
	public String concluirMaterial(long codigo) {
		Material material = mr.findByCodigo(codigo);
		mr.delete(material);
		return "redirect:/materiais";
	}
	
	
}
