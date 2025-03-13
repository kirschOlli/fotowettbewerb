package com.example.fotowettbewerb.controllers;


//import ch.qos.logback.core.model.Model;
import com.example.fotowettbewerb.Fotos;
import com.example.fotowettbewerb.Users;
import com.example.fotowettbewerb.repositories.FotosRepository;
import com.example.fotowettbewerb.repositories.UsersRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class UploadController {

    private final UsersRepository usersRepository;
    private final FotosRepository fotosRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    public UploadController(UsersRepository usersRepository, FotosRepository fotosRepository) {
        this.usersRepository = usersRepository;
        this.fotosRepository = fotosRepository;
    }

    @GetMapping("/upload")
    public String showUploadPage(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "upload";
    }


    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("username") String username,
                                   Model model) {
        try {
            Path userDir = Paths.get(uploadDir, username);
            Files.createDirectories(userDir);

            String fileName = username + "_" + System.currentTimeMillis() + ".jpg";
            Path filePath = userDir.resolve(fileName);
            Files.write(filePath, file.getBytes());

            Optional<Users> optionalUser = usersRepository.findByUsername(username);
            if (optionalUser.isPresent()) {
                Users user = optionalUser.get();

                String fileUrl = "/uploads/" + username + "/" + fileName; // Relativer Pfad für die Anzeige
                Fotos foto = new Fotos(fileUrl,user);
                fotosRepository.save(foto);

                model.addAttribute("message", "Datei erfolgreich hochgeladen:" + filePath);
            } else {
                model.addAttribute("message", "Username " + username + " geht nicht");
            }

        } catch (IOException e) {
            model.addAttribute("message", "An error occured: " + e.getMessage());
            e.printStackTrace();
        }
        return "upload";
    }


}
