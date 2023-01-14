package com.scaleupindia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.entity.Pet;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Value("${owner.not.found}")
	private String ownerNotFound;

	@Override
	public void saveOwner(OwnerDTO ownerDTO) {
		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.save(owner);
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			Owner owner = optionalOwner.get();
			return MapperUtil.convertOwnerEntityToDto(owner);
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			Owner owner = optionalOwner.get();
			Pet pet = owner.getPet();
			pet.setName(petName);
			owner.setPet(pet);
			ownerRepository.save(owner);
		}
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			ownerRepository.deleteById(ownerId);
		}
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAll().stream().map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public void updatePetDetailsV2(int ownerId, String petName) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			Owner owner = optionalOwner.get();
			ownerRepository.updatePetDetails(owner.getPet().getId(), petName);
		}
	}

	@Override
	public void deleteOwnerV2(int ownerId, int ownerId2) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			ownerRepository.deleteById(ownerId);
		}
		Optional<Owner> optionalOwner2 = ownerRepository.findById(ownerId2);
		if (optionalOwner2.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId2);
		} else {
			ownerRepository.deleteById(ownerId2);
		}
	}

	@Transactional(rollbackFor = OwnerNotFoundException.class)
	@Override
	public void deleteOwnerV3(int ownerId, int ownerId2) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			ownerRepository.deleteById(ownerId);
		}
		Optional<Owner> optionalOwner2 = ownerRepository.findById(ownerId2);
		if (optionalOwner2.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId2);
		} else {
			ownerRepository.deleteById(ownerId2);
		}
	}
}
