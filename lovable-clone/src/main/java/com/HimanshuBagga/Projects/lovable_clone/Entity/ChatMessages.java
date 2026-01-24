package com.HimanshuBagga.Projects.lovable_clone.Entity;

import com.HimanshuBagga.Projects.lovable_clone.enums.MessageRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ChatMessages {
    Long id;

    ChatSession chatSession;

    String content;

    String toolCalls;

    MessageRole role;

    Integer tokensUsed;

    Instant createdAt;

}