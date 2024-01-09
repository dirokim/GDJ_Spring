package com.winter.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

@Controller
@RequestMapping(value = "/regions/*")
public class RegionController {
	
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ModelAndView update(RegionDTO regionDTO,ModelAndView mv)throws Exception {
		int result = regionService.update(regionDTO);
		String message="수정 실패";
		if(result>0) {
			message = "수정 성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		return mv;
	
	}
	@RequestMapping(value="update",method=RequestMethod.GET)
	public void update(RegionDTO regionDTO , Model model)throws Exception {
		ModelAndView mv = new ModelAndView();
		regionDTO = regionService.getdetail(regionDTO);
		int result = regionService.update(regionDTO);
		model.addAttribute("dto",regionDTO);
	}
	
	@RequestMapping(value="delete",method= RequestMethod.POST)
	public ModelAndView delete(RegionDTO regionDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = regionService.delete(regionDTO);
		String msg="삭제실패";
		if(result>0) {
			msg = "삭제성공";
		}
		mv.addObject("msg",msg);
		mv.setViewName("commons/result");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(RegionDTO regionDTO, Model model) throws Exception {
	
		
		int result = regionService.add(regionDTO);
		
		String msg="등록 실패";
		if(result>0) {
			msg = "등록 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	

	
	@RequestMapping(value ="detail", method = RequestMethod.GET)
	//파라미터의 이름과 타입을 동일하게 선언
	//id
	public String detail(Integer region_id, Model model)throws Exception{
		
		
		RegionDTO regionDTO = new RegionDTO();
		//String id = request.getParameter("region_id");
		regionDTO.setRegion_id(region_id);
		regionDTO = regionService.getdetail(regionDTO);
		//request.setAttribute("dto", regionDTO);
		model.addAttribute("dto", regionDTO);
		return "regions/detail";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Regions List");
		RegionDAO regionDAO = new RegionDAO();
		List<RegionDTO> ar = regionService.getlist(pager);
		mv.addObject("list", ar);
		mv.setViewName("regions/list");
		mv.addObject("total",pager.getTotalPage());
		//return "regions/list";
		return mv;
	}

}
