package org.example.couponcore.repository.mysql;

import jakarta.persistence.LockModeType;
import org.example.couponcore.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {
//    @Query("SELECT c FROM Coupon c WHERE c.id = :id")
//    Optional<Coupon> findCouponWithLock(long id);
}
