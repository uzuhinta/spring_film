package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.config.FileStorageProperties;
import com.quannar.film.exception.FileStorageException;
import com.quannar.film.model.Actor;
import com.quannar.film.payload.request.ActorDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.ActorRepository;
import com.quannar.film.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private static final Logger logger = LoggerFactory.getLogger(ActorServiceImpl.class);

    private final Path fileStorageLocation;

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(
            FileStorageProperties fileStorageProperties,
            ActorRepository actorRepository,
            Validator validator
    ) {
        this.fileStorageLocation = Paths
                .get(fileStorageProperties.getUploadDirActor())
                .toAbsolutePath()
                .normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
        this.actorRepository = actorRepository;
    }

    @Override
    public void getActors(ResponseBean bean) throws Exception {
        List<Actor> allActor = actorRepository.getAllActor();
        bean.addData("actors", allActor);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    public void getActor(ResponseBean bean, Long actorId) throws Exception {
        Optional<Actor> actorById = actorRepository.getActorById(actorId);
        if(actorById.isPresent()) {
            bean.setError(Constant.ERROR_CODE_OK);
            bean.addData("actor",actorById.get());
        }else {
            bean.setError(Constant.ERROR_CODE_NOK);
            bean.setMessage(Constant.MSG_NOT_FOUND);
        }
    }

    @Override
    public void getActorWithPagination(ResponseBean bean, Integer page, Integer size) throws Exception {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Actor> actorWithPagination = actorRepository.getActorWithPagination(pageable);
        bean.addData("totalItem", actorWithPagination.getTotalElements());
        bean.addData("totalPage", actorWithPagination.getTotalPages());
        bean.addData("items", actorWithPagination.getContent());
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    public void create(ResponseBean bean, ActorDTO actorDTO) throws Exception {
        MultipartFile[] fileDatas = actorDTO.getFileDatas();
        Date date = new Date();
        long timeMilli = date.getTime();
        String uploadFileName = StringUtils.cleanPath(fileDatas[0].getOriginalFilename());
        String extension = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
        String fileName = String.format("%s.%s", timeMilli, extension);
                ;
        logger.info("processing upload file " + fileName);

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);

            Files.copy(fileDatas[0].getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            Actor newActor = new Actor(actorDTO.getName());

            if(!ObjectUtils.isEmpty(actorDTO.getDob())) {
                newActor.setDob(actorDTO.getDob());
            }

            if(!ObjectUtils.isEmpty(actorDTO.getSummary())) {
                newActor.setSummary(actorDTO.getSummary());
            }

            newActor.setImg(fileStorageLocation + FileSystems.getDefault().getSeparator() + fileName);

            actorRepository.saveAndFlush(newActor);

            bean.addData("actor", newActor);
            bean.setError(Constant.ERROR_CODE_OK);

        } catch (IOException ex) {
            bean.setError(Constant.ERROR_CODE_NOK);
            bean.setDescription("Could not store file " + fileName + ". Please try again!");
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    @Transactional
    public void deleteActorById(ResponseBean bean, Long actorId) throws Exception {
        Optional<Actor> actorById = actorRepository.getActorById(actorId);
        if(actorById.isPresent()){
            actorRepository.deleteActorById(actorId);
            bean.setMessage(Constant.MSG_DELETE_SUCCESS);
            bean.setError(Constant.ERROR_CODE_OK);
            bean.addData("actor", actorById);
        }else {
            bean.setDescription(Constant.MSG_NOT_FOUND);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
    }

    @Override
    public void updateActor(ResponseBean bean, Long actorId, ActorDTO actorDTO) throws Exception {
        Optional<Actor> actorById = actorRepository.getActorById(actorId);
        if(actorById.isPresent()){
            Actor actor = actorById.get();
            actor.setName(actorDTO.getName());
            actor.setDob(actorDTO.getDob());
            actor.setSummary(actorDTO.getSummary());
            actorRepository.saveAndFlush(actor);
            bean.setMessage(Constant.MSG_UPDATE_SUCCESS);
            bean.addData("actor", actor);
            bean.setError(Constant.ERROR_CODE_OK);
        }else {
            bean.setDescription(Constant.MSG_NOT_FOUND);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
    }
}
