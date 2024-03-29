package org.masterserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masterserver.model.PunishmentModel;
import org.masterserver.repository.PunishmentRepository;
import org.masterserver.service.PunishmentServiceTests;
import org.masterserver.util.CustomDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

public class PunishmentServiceImplTests implements PunishmentServiceTests {

	@Mock
	private PunishmentRepository repository;
	
	@InjectMocks
	private PunishmentServiceImpl service;
	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Override
	public void getAll() {
		Mockito.when(repository.findAll()).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PunishmentModel> punishments = service.getAll();
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

	@Test
	@Override
	public void getById() {
		PunishmentModel punishment = new PunishmentModel(1l, "desc", "ban", CustomDate.getCurrentDate());
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(punishment));
		PunishmentModel result = service.getById(Mockito.anyLong());
		Assertions.assertEquals(1l, result.getId());
		Assertions.assertEquals("desc", result.getDescription());
		Assertions.assertEquals("ban", result.getType());
		Assertions.assertNotNull(result.getDate());
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	@Override
	public void create() {
		PunishmentModel punishment = new PunishmentModel(1l, "desc", "ban", CustomDate.getCurrentDate());
		Mockito.when(repository.save(punishment)).thenReturn(punishment);
		Assertions.assertThrows(NullPointerException.class, () -> {
			PunishmentModel result = service.create(punishment);
			Assertions.assertNull(result);
	    });
		Mockito.verify(repository, Mockito.times(0)).save(punishment);
	}

	@Test
	@Override
	public void update() {
		PunishmentModel punishment = new PunishmentModel(1l, "desc", "ban", CustomDate.getCurrentDate());
		Mockito.when(repository.save(punishment)).thenReturn(punishment);
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.update(1l, punishment);
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).save(punishment);
	}

	@Test
	@Override
	public void delete() {
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			service.delete(Mockito.anyLong());
	    });
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(repository, Mockito.times(0)).deleteById(Mockito.anyLong());
	}
	
	@Test
	@Override
	public void getByType() {
		Mockito.when(repository.findByType((Mockito.anyString()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PunishmentModel> punishments = service.getByType(Mockito.anyString());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByType(Mockito.anyString());
	}

	@Test
	@Override
	public void getByDate() {
		Mockito.when(repository.findByDate((Mockito.any()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PunishmentModel> punishments = service.getByDate(Mockito.any());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDate(Mockito.any());
	}

	@Test
	@Override
	public void getByDescription() {
		Mockito.when(repository.findByDescription((Mockito.anyString()))).thenReturn(new ArrayList<PunishmentModel>());
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			List<PunishmentModel> punishments = service.getByDescription(Mockito.anyString());
			Assertions.assertNull(punishments);
	    });
		Mockito.verify(repository, Mockito.times(1)).findByDescription(Mockito.anyString());
	}

}
