package com.empresa.entranssa.Dao;

import com.empresa.entranssa.Model.BusConductor;
import com.empresa.entranssa.Model.BusConductorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusConductorDAO extends JpaRepository<BusConductor, BusConductorId> {
}
