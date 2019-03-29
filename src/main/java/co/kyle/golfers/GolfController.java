package co.kyle.golfers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kyle.golfers.model.Players;

@Controller
public class GolfController {

	@Autowired
	ApiService api = new ApiService();

	@RequestMapping("/")
	public ModelAndView home() {

		return new ModelAndView("index");
	}

	@RequestMapping("/result")
	public ModelAndView results(@RequestParam("year") Integer year) {

		ModelAndView mav = new ModelAndView("result");

		Integer year1 = year;
		Integer year2 = year + 1;
		Integer year3 = year + 2;

		List<Players> player1 = api.getPlayersByYear(year1);
		List<Players> player2 = api.getPlayersByYear(year2);
		List<Players> player3 = api.getPlayersByYear(year3);

		if (player1 != null || player2 != null || player3 != null) {
			mav.addObject("player1", player1);
			mav.addObject("player2", player2);
			mav.addObject("player3", player3);
			mav.addObject("season1", year1);
			mav.addObject("season2", year2);
			mav.addObject("season3", year3);
			return mav;
		}

		return new ModelAndView("redirect:/");

	}

}
