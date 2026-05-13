package com.example.week8lab.config;

import com.example.week8lab.model.*;
import com.example.week8lab.repository.AssociationRepository;
import com.example.week8lab.repository.ContactRepository;
import com.example.week8lab.repository.EventRepository;
import com.example.week8lab.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            ContactRepository contactRepository,
            AssociationRepository associationRepository,
            EventRepository eventRepository,
            TaskRepository taskRepository
    ) {
        return args -> {

            Contact contact1 = new Contact();
            contact1.setCompany("Amazon");
            contact1.setTitle("Manager");
            contact1.setName(new Name("Mr.", "John", "A", "Smith"));

            Contact contact2 = new Contact();
            contact2.setCompany("Google");
            contact2.setTitle("Public Relations Officer");
            contact2.setName(new Name("Dr.", "Anna", "M", "Brown"));

            Contact contact3 = new Contact();
            contact3.setCompany("Microsoft");
            contact3.setTitle("Coordinator");
            contact3.setName(new Name("Mrs.", "Laura", "K", "Wilson"));

            contactRepository.save(contact1);
            contactRepository.save(contact2);
            contactRepository.save(contact3);

            Association association = new Association();
            association.setName("Nurse Association of Spain");

            for (int i = 1; i <= 7; i++) {
                Member president = new Member();
                president.setName("President " + i);
                president.setStatus(MemberStatus.ACTIVE);
                president.setRenewalDate(LocalDate.now().plusMonths(i));

                Member member = new Member();
                member.setName("Member " + i);
                member.setStatus(MemberStatus.ACTIVE);
                member.setRenewalDate(LocalDate.now().plusMonths(i + 1));

                Division division = new Division();
                division.setName("Division " + i);
                division.setDistrict("District " + i);
                division.setPresident(president);
                division.getMembers().add(president);
                division.getMembers().add(member);

                association.getDivisions().add(division);
            }

            associationRepository.save(association);

            Guest guest1 = new Guest();
            guest1.setName("Alex Green");
            guest1.setStatus(GuestStatus.ATTENDING);

            Guest guest2 = new Guest();
            guest2.setName("Maria Black");
            guest2.setStatus(GuestStatus.NO_RESPONSE);

            Guest guest3 = new Guest();
            guest3.setName("Robert White");
            guest3.setStatus(GuestStatus.NOT_ATTENDING);

            Speaker speaker1 = new Speaker();
            speaker1.setName("David Miller");
            speaker1.setPresentationDuration(60);

            Speaker speaker2 = new Speaker();
            speaker2.setName("Sarah Clark");
            speaker2.setPresentationDuration(45);

            Conference conference = new Conference();
            conference.setTitle("Java Conference");
            conference.setDate(LocalDate.now().plusDays(10));
            conference.setDuration(5);
            conference.setLocation("Berlin");
            conference.getGuests().add(guest1);
            conference.getGuests().add(guest2);
            conference.getSpeakers().add(speaker1);
            conference.getSpeakers().add(speaker2);

            Exhibition exhibition = new Exhibition();
            exhibition.setTitle("Technology Exhibition");
            exhibition.setDate(LocalDate.now().plusDays(20));
            exhibition.setDuration(4);
            exhibition.setLocation("Munich");
            exhibition.getGuests().add(guest3);

            eventRepository.save(conference);
            eventRepository.save(exhibition);

            BillableTask billableTask = new BillableTask();
            billableTask.setTitle("Backend API");
            billableTask.setDueDate(LocalDate.now().plusDays(7));
            billableTask.setCompleted(false);
            billableTask.setHourlyRate(new BigDecimal("50.00"));

            InternalTask internalTask1 = new InternalTask();
            internalTask1.setTitle("Team Meeting");
            internalTask1.setDueDate(LocalDate.now().plusDays(2));
            internalTask1.setCompleted(false);

            InternalTask internalTask2 = new InternalTask();
            internalTask2.setTitle("Documentation");
            internalTask2.setDueDate(LocalDate.now().plusDays(5));
            internalTask2.setCompleted(true);

            taskRepository.save(billableTask);
            taskRepository.save(internalTask1);
            taskRepository.save(internalTask2);
        };
    }
}
