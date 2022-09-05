package com.shridhar.demo.service.mongo;

import com.shridhar.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component public class BookModelListener extends AbstractMongoEventListener<Book> {

    @Autowired private SequenceGeneratorService sequenceGeneratorService;

    @Override public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
        }
    }
}
