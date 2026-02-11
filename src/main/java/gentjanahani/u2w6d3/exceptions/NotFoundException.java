package gentjanahani.u2w6d3.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID idAutore) {
        super("Elemento con id: " + idAutore + " non è stato trovato.");
    }
}
