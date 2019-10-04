package com.startup.library.repository;

import com.startup.library.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,Long> {
}
