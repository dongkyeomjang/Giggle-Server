package com.inglo.giggle.document.domain;

import com.inglo.giggle.core.dto.BaseEntity;
import com.inglo.giggle.core.type.EDayOfWeek;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "contract_work_day_times")
@SQLDelete(sql = "UPDATE contract_work_day_times SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class ContractWorkDayTime extends BaseEntity {

    /* -------------------------------------------- */
    /* Default Column ----------------------------- */
    /* -------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* -------------------------------------------- */
    /* Information Column ------------------------- */
    /* -------------------------------------------- */
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private EDayOfWeek dayOfWeek;

    @Column(name = "work_start_time", nullable = false)
    private LocalTime workStartTime;

    @Column(name = "work_end_time", nullable = false)
    private LocalTime workEndTime;

    @Column(name = "break_start_time", nullable = false)
    private LocalTime breakStartTime;

    @Column(name = "break_end_time", nullable = false)
    private LocalTime breakEndTime;

    /* -------------------------------------------- */
    /* Many To One Mapping ------------------------ */
    /* -------------------------------------------- */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_contract_id", nullable = false)
    private StandardLaborContract standardLaborContract;

    /* -------------------------------------------- */
    /* Methods ------------------------------------ */
    /* -------------------------------------------- */
    @Builder
    public ContractWorkDayTime(EDayOfWeek dayOfWeek, LocalTime workStartTime, LocalTime workEndTime,
                               LocalTime breakStartTime, LocalTime breakEndTime, StandardLaborContract standardLaborContract) {
        this.dayOfWeek = dayOfWeek;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.breakStartTime = breakStartTime;
        this.breakEndTime = breakEndTime;
        this.standardLaborContract = standardLaborContract;
    }
}