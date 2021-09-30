package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.model.Film;
import com.quannar.film.model.Type;
import com.quannar.film.payload.request.FilmDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.FilmRepository;
import com.quannar.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public void getAll(ResponseBean bean) {
        List<Film> allFilm = filmRepository.getAllFilm();
        bean.addData("films", allFilm);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    public void create(ResponseBean bean, FilmDTO filmDTO) {
        Film film = new Film(filmDTO.getName(),
                filmDTO.getNum_chap(),
                filmDTO.getTimePerChap(),
                filmDTO.getNational(),
                filmDTO.getReleaseAt(),
                filmDTO.getQuality(),
                filmDTO.getScore(),
                filmDTO.getStart());
        filmRepository.saveAndFlush(film);
        bean.addData("film", film);
        bean.setDescription(Constant.MSG_CREATE_SUCCESS);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    @Transactional
    public void deleteFilmById(ResponseBean bean, Long filmId) {

        Optional<Film> optionalFilm = filmRepository.getFilmById(filmId);

        if (optionalFilm.isPresent()) {
            filmRepository.deleteTypeById(filmId);
            bean.setMessage(Constant.MSG_DELETE_SUCCESS);
            bean.addData("film", optionalFilm);
            bean.setError(Constant.ERROR_CODE_OK);
        } else {
            bean.setMessage(Constant.MSG_NOT_FOUND);
            bean.setError(Constant.ERROR_CODE_NOK);
        }

    }
}
