package br.com.florum.service;

import br.com.florum.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}