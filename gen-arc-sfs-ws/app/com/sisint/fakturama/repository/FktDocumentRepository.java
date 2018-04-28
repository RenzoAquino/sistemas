package com.sisint.fakturama.repository;

import com.sisint.fakturama.models.FktDocument;
import com.sisint.generador.resources.GeneradorResource;

import java.util.Optional;
import java.util.concurrent.CompletionStage;

public interface FktDocumentRepository {

    CompletionStage<Optional<FktDocument>> getByNumber(GeneradorResource resource);
/*
    CompletionStage<Stream<PostData>> list();

    CompletionStage<PostData> create(PostData postData);

    CompletionStage<Optional<PostData>> get(Long id);

    CompletionStage<Optional<PostData>> update(Long id, PostData postData);
    */
}

