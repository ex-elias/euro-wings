package com.eurowings.utils;

import io.qameta.allure.Attachment;

public final class AttachmentUtils {

    private AttachmentUtils() {
    }

    @Attachment(type = "image/png", value = "{name}")
    public static byte[] makeImagesAttachment(final String name, final byte[] source) {
        return source;
    }
}
