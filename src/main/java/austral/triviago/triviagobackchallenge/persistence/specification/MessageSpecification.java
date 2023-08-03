package austral.triviago.triviagobackchallenge.persistence.specification;

import austral.triviago.triviagobackchallenge.persistence.domain.Message;
import austral.triviago.triviagobackchallenge.presentation.dto.MessageFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MessageSpecification implements Specification<Message> {

    private final MessageFilter messageFilter;

    public MessageSpecification(MessageFilter messageFilter) {
        this.messageFilter = messageFilter;
    }

    @Override
    public Predicate toPredicate(Root<Message> message, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> restrictions = new ArrayList<>();
        // Filters by author equality
        if (messageFilter.getAuthor() != null && !messageFilter.getAuthor().equals("")) {
            restrictions.add(criteriaBuilder.equal(message.get("content"), messageFilter.getAuthor()));
        }
        return criteriaBuilder.and(restrictions.toArray(new Predicate[0]));
    }
}
