package co.kyle.golfers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

		Integer year1 = range(year);
		Integer year2 = year + 1;

		List<Players> player1 = api.getPlayersByYear(year1);
		List<Players> player2 = api.getPlayersByYear(year2);

		mav.addObject("player1", player1);
		mav.addObject("player2", player2);

		mav.addObject("season1", year1);
		mav.addObject("season2", year2);

		return mav;
	}

	@RequestMapping("/new/{year}")
	public ModelAndView result(@PathVariable(value = "year", required = false) Integer year) {

		ModelAndView mav = new ModelAndView("results");

		Integer year1 = range(year);
		Integer year2 = year + 1;

		List<Players> player1 = api.getPlayersByYear(year1);
		List<Players> player2 = api.getPlayersByYear(year2);

		mav.addObject("player1", player1);
		mav.addObject("player2", player2);

		mav.addObject("season1", year1);
		mav.addObject("season2", year2);

		return mav;

	}

	private Integer range(Integer year) {

		if (year < 2015) {

			return 2015;
		} else if (year > 2018) {
			return 2018;
		} else {
			return year;
		}

	}

}
