package app.controle.negocio;

import java.io.File;

public class Arquivo extends File{
	public Arquivo(String pathname) {
        super(pathname);
    }

    private static final long serialVersionUID = 1L;

    public boolean isValido() {
		return true;
	}

}
