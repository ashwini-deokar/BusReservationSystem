import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class AppointmentSystemApplication {

    // Sample Doctor Data (In-memory storage, replace with a database)
    private List<Doctor> doctors = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(AppointmentSystemApplication.class, args);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorDetail(@PathVariable Long id) {
        // Find the doctor by ID (Replace with actual database query)
        return findDoctorById(id);
    }

    @PostMapping("/appointments")
    public String bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        // Check if the doctor and appointment slot are available
        Doctor doctor = findDoctorById(appointmentRequest.getDoctorId());

        if (doctor != null && doctor.isAppointmentAvailable(appointmentRequest.getAppointmentTime())) {
            // Create an appointment (Store it in the database)
            // In a real implementation, you'd save the appointment data to a database
            // and perform other necessary operations.
            return "Appointment booked successfully!";
        } else {
            return "Appointment could not be booked. Please choose a different time or doctor.";
        }
    }

    // Helper method to find a doctor by ID
    private Doctor findDoctorById(Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Initialize some sample data
    private void initializeSampleData() {
        doctors.add(new Doctor(1L, "Dr. Smith", "Cardiology", 5)); // Doctor with ID 1
        doctors.add(new Doctor(2L, "Dr. Johnson", "Dermatology", 4)); // Doctor with ID 2
        // Add more doctors here
    }
}

class Doctor {
    private Long id;
    private String name;
    private String specialization;
    private int maxAppointmentsPerDay;
    // Other doctor details

    public Doctor(Long id, String name, String specialization, int maxAppointmentsPerDay) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.maxAppointmentsPerDay = maxAppointmentsPerDay;
        // Initialize other doctor details
    }

    // Getter methods for doctor attributes

    public boolean isAppointmentAvailable(String appointmentTime) {
        // Implement logic to check if the appointment slot is available
        // You can add more logic here, e.g., checking against a schedule
        return true;
    }
}

class AppointmentRequest {
    private Long doctorId;
    private String appointmentTime;

    // Getter and setter methods for appointment request attributes

    // Additional attributes like patient information can be added here
}
