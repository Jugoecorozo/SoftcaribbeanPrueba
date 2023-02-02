package com.pruebaingreso.softcaribbean.controller;

import com.pruebaingreso.softcaribbean.dto.Message;
import com.pruebaingreso.softcaribbean.dto.Paciente;
import com.pruebaingreso.softcaribbean.exception.ControllerException;
import com.pruebaingreso.softcaribbean.exception.FacadeException;
import com.pruebaingreso.softcaribbean.facade.IntFacPaciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacienteapi")
public class PacienteController {
    private IntFacPaciente PF;

    @PostMapping("/save")
    public ResponseEntity<Message> Process(@RequestBody Paciente p) throws ControllerException{
        Message message = new Message("0","Succesful Save", null);
        try {
            PF.Process(p);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en guardar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<Message> Delete(@RequestBody Paciente p) throws ControllerException{
        Message message = new Message("0","Succesful Save", null);
        try {
            PF.Delete(p);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error al eliminar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getall")
    public ResponseEntity<Message> SelectAll() throws ControllerException{
        Message message = new Message("0","Succesful Save", null);
        try {
            List<Paciente> list = PF.SelectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
