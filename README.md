# J.A.V.I.P.  
**Just A Very Intelligent Pi Journal**

A personal dashboard running on a Raspberry Pi.

---

## Overview

J.A.V.I.P. is a self-hosted dashboard that lives on your Raspberry Pi. It includes:

- A daily journal
- Task list
- Random daily reminders (from a user-defined pool  great for memorization or motivation)
- Bonus objectives of the day
- Media recommendations (games, music, movies)
- Weather and sensor-based data visualization (starting with APIs, then using Pi sensors)

---

## Tech Stack

### Backend
- Java (17+)
- Spring Boot (RESTful API)
- Spring Data JPA
- Maven
- Lombok (for reducing boilerplate)

### Frontend
- React (with Vite)
- React Router
- Axios/Fetch for API calls
- Electron or Pkg (to maybe package as a standalone executable)

### Database
- SQLite (local storage)
- Hibernate / JPA for ORM

### Extras
- Swagger (for auto-generating API documentation)
- Picovoice or Rhasspy (for offline voice commands)

---

## User Stories (Conceptual Goals)

- As a user, I can write daily journal entries to reflect on my day and track progress.
- As a user, I can manage tasks  add, edit, mark as done.
- As a user, I receive one random reminder per day from a list I've created (facts, quotes, etc.).
- As a user, I get a new "bonus objective" each day to encourage new habits or challenges.
- As a user, I can see real-time weather on my dashboard.
- As a developer, I can swap API-based weather data with Raspberry Pi sensor input.
- As a user, I can use a voice assistant to summarize my day or list tasks.
- As a user, I get a song recommendation every day to discover new music.
- As a user, I get a weekly game recommendation from Backloggd.
- As a user, I receive curated movie/show suggestions (daily or monthly you can set intervals).
- As a user, I can track personal bests in whatever metrics I choose (fitness, time, scores, etc.).
- As a user, I want a clean, responsive interface I can use directly from the Pi.
- As a developer, I want the app to start automatically on boot.

---

## UML Diagram

coming soon....

---
