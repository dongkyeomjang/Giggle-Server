package com.inglo.giggle.banner.application.service;

import com.inglo.giggle.banner.application.usecase.DeleteAdminBannerUseCase;
import com.inglo.giggle.banner.repository.mysql.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteAdminBannerService implements DeleteAdminBannerUseCase {

    private final BannerRepository bannerRepository;

    @Override
    public void execute(UUID accountId, Long bannerId) {

        bannerRepository.deleteById(bannerId);
    }
}
