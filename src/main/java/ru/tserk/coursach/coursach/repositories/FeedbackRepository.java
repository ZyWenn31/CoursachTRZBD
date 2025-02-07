package ru.tserk.coursach.coursach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tserk.coursach.coursach.models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
