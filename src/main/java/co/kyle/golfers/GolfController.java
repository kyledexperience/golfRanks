package co.kyle.golfers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kyle.golfers.model.Players;

@Controller
public class GolfController {

	@Autowired
	ApiService api = new ApiService();

	@RequestMapping("/")
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("index");

		String season1 = "2016";
		String season2 = "2017";
		String season3 = "2018";

		List<Players> player1 = api.getPlayersByYear(season1);
		List<Players> player2 = api.getPlayersByYear(season2);
		List<Players> player3 = api.getPlayersByYear(season3);

		mav.addObject("player1", player1);
		mav.addObject("player2", player2);
		mav.addObject("player3", player3);
		mav.addObject("season1", season1);
		mav.addObject("season2", season2);
		mav.addObject("season3", season3);

		return mav;

	}

}
