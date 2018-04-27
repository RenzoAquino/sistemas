package com.sisint.fakturama.repository;

import com.sisint.fakturama.models.FktDocument;

import java.util.Optional;
import java.util.concurrent.CompletionStage;

public interface FktDocumentRepository {

    CompletionStage<Optional<FktDocument>> getByNumber(String number);
/*
    CompletionStage<Stream<PostData>> list();

    CompletionStage<PostData> create(PostData postData);

    CompletionStage<Optional<PostData>> get(Long id);

    CompletionStage<Optional<PostData>> update(Long id, PostData postData);
    */
}

