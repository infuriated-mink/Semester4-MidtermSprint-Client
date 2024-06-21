# Semester4-MidtermSprint-Client
---
# REST Client for Event Management System

This project is a simple Java-based client application that interacts with a RESTful API server. The client can perform various operations such as listing events at a specific venue, listing all attendees for a specific event, listing all events for a specific attendee, and listing all speakers for a specific event.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/yourusername/event-management-client.git
    cd event-management-client
    ```

2. **Compile the project:**

    ```sh
    javac -d bin src/com/keyin/http/client/RESTClient.java src/com/keyin/http/cli/HTTPRestCLIApplication.java
    ```

3. **Run the application:**

    ```sh
    java -cp bin com.keyin.http.cli.HTTPRestCLIApplication
    ```

## Usage

The client application provides a command-line interface (CLI) to interact with the RESTful API server. Follow the prompts to perform various operations.

### Example Commands

1. **List events at a specific venue:**

    - Enter the venue ID when prompted.

2. **List all attendees for a specific event:**

    - Enter the event ID when prompted.

3. **List all events for a specific attendee:**

    - Enter the attendee ID when prompted.

4. **List all events for a specific dae:**

    - Enter the date in (YYYY-MM-DD).

5. **Exit the application:**

    - Choose the exit option from the menu.

## Features

- **GET Requests:**
  - List events at a specific venue.
  - List all attendees for a specific event.
  - List all events for a specific attendee.
  - List all speakers for a specific event.

- **POST Requests:**
  - Send JSON data to the server (example provided in the main method).

## Contributing

1. **Fork the repository.**

2. **Create a new branch:**

    ```sh
    git checkout -b feature-branch
    ```

3. **Make your changes and commit them:**

    ```sh
    git commit -m 'Add some feature'
    ```

4. **Push to the branch:**

    ```sh
    git push origin feature-branch
    ```

5. **Create a pull request.**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

**Note:** This project is part of a sprint week assignment. The server-side implementation is required to be running for the client to function correctly. Ensure the server is up and running on `http://localhost:8080` before using the client application.
