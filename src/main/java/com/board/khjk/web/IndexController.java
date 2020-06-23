package com.board.khjk.web;

import com.board.khjk.service.PostsService;
import com.board.khjk.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        Map<String,Object> map = model.asMap();
        if(model == null){
            System.out.println(">>>>>>>>모델이 ㅇ비었단다!!!!!!!!!");
        }
        for(String key : map.keySet()){
            System.out.println(">>>>!!!!!!!!!!!!!!!!!!!!!!!!!!>>>>" + key+" : " + map.get(key).toString());
        }
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
