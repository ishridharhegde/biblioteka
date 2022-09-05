package com.shridhar.demo.service.mongo;

import com.shridhar.demo.model.Book;
import com.shridhar.demo.model.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public SequenceGeneratorService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	/**
	 * This function generates an auto-incremented integer ID which can be used for adding new books
	 * @param seqName
	 * @return Returns an auto incremented ID value
	 */
	public long generateSequence(String seqName) {
		DatabaseSequence bookCounter = mongoOperations.findAndModify(Query.query(Criteria.where("_id").is(seqName)),
				new Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
				DatabaseSequence.class);
		return !Objects.isNull(bookCounter) ? bookCounter.getSeq() : 1;
	}

}
