package com.date.datingapp.domain.entity.user;

import com.date.datingapp.domain.entity.user.photo.Photo;
import com.date.datingapp.domain.entity.user.photo.PhotoId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final UserId id;
    private final Email email;
    private final PasswordHash password;
    private final Profile profile;
    private final List<Photo> photos;
    private boolean verified;
    private boolean premium;


    private User(UserId id, Email email, PasswordHash password, Profile profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.photos = new ArrayList<>();
        this.verified = false;
        this.premium = false;
    }

    public static User register(String email, String password, Profile profile) {
        return new User(UserId.generate(), new Email(email), new PasswordHash(password), profile);
    }

    public void uploadPhoto(String url) {
        photos.add(Photo.upload(url));
    }

    public void verifyPhoto(PhotoId photoId) {
        photos.stream()
                .filter(p -> p.getId().equals(photoId))
                .findFirst()
                .ifPresent(Photo::markVerified);
        if (photos.stream().anyMatch(Photo::isVerified)) {
            this.verified = true;
        }
    }

    public void activatePremium() {
        if (!verified) {
            throw UserError.errCannotBeActivated();
        }
        this.premium = true;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isPremium() {
        return premium;
    }

    public UserId getId() {
        return id;
    }

    public List<Photo> getPhotos() {
        return Collections.unmodifiableList(photos);
    }

    public Email getEmail() {
        return email;
    }

}
