package com.cala.dao.filters.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;

@SpringBootTest
public abstract class FilterDaoTest<T extends I_FilterDao<E>,
								E extends GenericFilterVo> {

	@Autowired
	private T dao;
	public abstract void delete(Filterable filter);
	public abstract Filterable create(String name, boolean active);
	public abstract List<GenericFilterVo> getAll(PaginationVo pagination);
	public abstract E createVo(Filterable filter);
	public abstract Filterable findByName(String name);
	
	public T getDao() {
		return dao;
	}
	
	@Test
	void testGetById() {
		Filterable filter = create("test", true);
		E filterVo = createVo(filter);
		getDao().store(filterVo);
		filterVo = getDao().findByName("test");
		assertNotNull(filterVo);
		E filterVo1 = getDao().findById(filterVo.getId());
		assertEquals(filterVo.getName(), filterVo1.getName());
		
		filter = findByName("test");
		delete(filter);		
	}
	
	@Test
	void testActive() {
		Filterable filter = create("test", true);
		E filterVo = createVo(filter);
		getDao().store(filterVo);
		
		filterVo = getDao().findByName("test");
		getDao().disable(filterVo.getId());
		filterVo = getDao().findByName("test");
		assertFalse(filterVo.isActive());
		
		getDao().enable(filterVo.getId());
		filterVo = getDao().findByName("test");
		assertTrue(filterVo.isActive());
		
		filter = findByName("test");
		delete(filter);
	}
	
	@Test
	void testGetAll() {
		
		Filterable test = create("test", true);
		E testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test1", true);
		testVo = createVo(test);	
		getDao().store(testVo);	
		test = create("test2", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test3", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test4", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test5", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test6", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test7", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test8", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test9", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		test = create("test10", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		
		
		//first case
		PaginationVo pagination = new PaginationVo(0, 10);
		List<GenericFilterVo> filters = getAll(pagination);
		assertEquals(10, filters.size());
		pagination.setPage(1);
		filters = getAll(pagination);
		assertEquals(1, filters.size());
		
		//second case
		pagination.setPage(0);
		pagination.setSize(5);
		filters = getAll(pagination);
		assertEquals(5, filters.size());
		pagination.setPage(1);
		filters = getAll(pagination);
		assertEquals(5, filters.size());
		pagination.setPage(2);
		filters = getAll(pagination);
		assertEquals(1, filters.size());
		
		//remove all
		test = findByName("test");
		delete(test);	
		test = findByName("test1");
		delete(test);		
		test = findByName("test2");
		delete(test);		
		test = findByName("test3");
		delete(test);
		test = findByName("test4");
		delete(test);
		test = findByName("test5");
		delete(test);
		test = findByName("test6");
		delete(test);
		test = findByName("test7");
		delete(test);
		test = findByName("test8");
		delete(test);
		test = findByName("test9");
		delete(test);
		test = findByName("test10");
		delete(test);
	}
	
	@Test
	void testStoreUpdate() {
		Filterable test = create("test", true);
		E testVo = createVo(test);	
		getDao().store(testVo);
		
		//update
		E filter = getDao().findByName("test");
		assertNotNull(filter);
		filter.setName("test1");
		getDao().rename(filter);		
		filter = getDao().findByName("test");
		assertNull(filter);		
		filter = getDao().findByName("test1");
		assertNotNull(filter);
		filter.setName("test");
		getDao().rename(filter);		
		filter = getDao().findByName("test");
		assertNotNull(filter);
		filter = getDao().findByName("test1");
		assertNull(filter);	

		//store
		test = create("test1", true);
		testVo = createVo(test);	
		getDao().store(testVo);
		List<GenericFilterVo> filters = getAll(new PaginationVo(0, 10));
		assertEquals(2, filters.size());
		test = findByName("test1");
		//remove
		delete(test);
		filters = getDao().getAll(new PaginationVo(0, 10));
		assertEquals(1, filters.size());		
		test = findByName("test");
		delete(test);	
		filters = getDao().getAll(new PaginationVo(0, 10));
		assertEquals(0, filters.size());	
	}
	
	
}
