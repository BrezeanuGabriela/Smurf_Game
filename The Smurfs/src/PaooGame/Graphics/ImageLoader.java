package PaooGame.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.System.exit;

public class ImageLoader
{
    /*! \fn  public static BufferedImage loadImage(String path)
        \brief Incarca o imagine intr-un obiect BufferedImage si returneaza o referinta catre acesta.

        \param path Calea relativa pentru localizarea fisierul imagine.
     */
    public static BufferedImage LoadImage(String path)
    {
        try
        {
            System.out.println("image load");
            return ImageIO.read(new File(path));
        }
        catch(IOException e)
        {
            /// Afiseaza informatiile necesare depanarii.
            e.printStackTrace();
        }
        return null;
    }}

