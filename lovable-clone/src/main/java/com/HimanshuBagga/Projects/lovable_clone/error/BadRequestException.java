package com.HimanshuBagga.Projects.lovable_clone.error;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class BadRequestException extends RuntimeException{
    String message;
}
