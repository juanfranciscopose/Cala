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

import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.GenericFilterRepository;

@SpringBootTest
public abstract class FilterDaoTest<T extends FilterDao<K, E>,
								K extends GenericFilter, 
								E extends GenericFilterVo> {

	@Autowired
	private T dao;
	
	@Autowired
	private GenericFilterRepository<K> repository;
	
	public abstract K create(String name, boolean active);
	
	public abstract E createVo(K filter);
	
	public T getDao() {
		return dao;
	}
	
	public GenericFilterRepository<K> getRepository() {
		return repository;
	}
	
	@Test
	void testGetById() {
		K filter = create("test", true);
		E filterVo = createVo(filter);
		getDao().store(filterVo);
		filterVo = getDao().findByName("test");
		assertNotNull(filterVo);
		E filterVo1 = getDao().findById(filterVo.getId());
		assertEquals(filterVo.getName(), filterVo1.getName());
		
		filter = getRepository().findByName("test").get();
		getRepository().delete(filter);		
	}
	
	@Test
	void testActive() {
		K filter = create("test", true);
		E filterVo = createVo(filter);
		getDao().store(filterVo);
		
		filterVo = getDao().findByName("test");
		getDao().disable(filterVo.getId());
		filterVo = getDao().findByName("test");
		assertFalse(filterVo.isActive());
		
		getDao().enable(filterVo.getId());
		filterVo = getDao().findByName("test");
		assertTrue(filterVo.isActive());
		
		filter = getRepository().findByName("test").get();
		getRepository().delete(filter);
	}
	
	@Test
	void testGetAll() {
		
		K test = create("test", true);
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
		List<E> filters = getDao().getAll(pagination);
		assertEquals(10, filters.size());
		pagination.setPage(1);
		filters = getDao().getAll(pagination);
		assertEquals(1, filters.size());
		
		//second case
		pagination.setPage(0);
		pagination.setSize(5);
		filters = getDao().getAll(pagination);
		assertEquals(5, filters.size());
		pagination.setPage(1);
		filters = getDao().getAll(pagination);
		assertEquals(5, filters.size());
		pagination.setPage(2);
		filters = getDao().getAll(pagination);
		assertEquals(1, filters.size());
		
		//remove all
		test = getRepository().findByName("test").get();
		getRepository().delete(test);	
		test = getRepository().findByName("test1").get();
		getRepository().delete(test);		
		test = getRepository().findByName("test2").get();
		getRepository().delete(test);		
		test = getRepository().findByName("test3").get();
		getRepository().delete(test);
		test = getRepository().findByName("test4").get();
		getRepository().delete(test);
		test = getRepository().findByName("test5").get();
		getRepository().delete(test);
		test = getRepository().findByName("test6").get();
		getRepository().delete(test);
		test = getRepository().findByName("test7").get();
		getRepository().delete(test);
		test = getRepository().findByName("test8").get();
		getRepository().delete(test);
		test = getRepository().findByName("test9").get();
		getRepository().delete(test);
		test = getRepository().findByName("test10").get();
		getRepository().delete(test);
	}
	
	@Test
	void testStoreUpdate() {
		K test = create("test", true);
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
		List<E> filters = getDao().getAll(new PaginationVo(0, 10));
		assertEquals(2, filters.size());
		test = repository.findByName("test1").get();
		//remove
		repository.delete(test);
		filters = getDao().getAll(new PaginationVo(0, 10));
		assertEquals(1, filters.size());		
		test = getRepository().findByName("test").get();
		getRepository().delete(test);	
		filters = getDao().getAll(new PaginationVo(0, 10));
		assertEquals(0, filters.size());	
	}
	
	
}
