package com.holy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holy.entity.Items;
import com.holy.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Resource
	private ItemsService itemsService;

	@RequestMapping("list")
	public String list(Model model) {
		List<Items> list = itemsService.findAll();
		model.addAttribute("itemsList", list);
		return "itemsList";
	}

	@RequestMapping("edit")
	public String edit(Integer id, Model model) {
		Items items = itemsService.findByID(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	/**
	 * 
	 * @param items
	 * @return
	 * items的属性 detail 在数据库中的数据类型为 text 逆向工程根据数据库生成xml文件时，
	 * 没有进行类型转换，导致update这个sql标签没有 detail这个字段
	 */
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items items) {
		itemsService.saveOrUpdate(items);
		return "redirect:list.do";
	}

	@RequestMapping("deleteByID")
	public String deleteByID(Integer id) {
		itemsService.deleteByID(id);
		return "redirect: list.do";
	}
	@RequestMapping("deleteByIds")
	public String deleteByIds(Integer[] id) {
		for (Integer ids : id) {
			itemsService.deleteByID(ids);
		}
		return "redirect: list.do";
	}
}
