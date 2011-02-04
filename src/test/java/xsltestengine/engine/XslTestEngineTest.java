package xsltestengine.engine;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.servicelibre.jxsl.scenario.XslScenario;
import com.servicelibre.jxsl.xsltestengine.AlwaysFalseValidator;
import com.servicelibre.jxsl.xsltestengine.AlwaysTrueValidator;
import com.servicelibre.jxsl.xsltestengine.DocumentId;
import com.servicelibre.jxsl.xsltestengine.DocumentSource;
import com.servicelibre.jxsl.xsltestengine.FolderDocumentSource;
import com.servicelibre.jxsl.xsltestengine.JavaXslOutputValidation;
import com.servicelibre.jxsl.xsltestengine.OutputValidator;
import com.servicelibre.jxsl.xsltestengine.XslOutputValidation;
import com.servicelibre.jxsl.xsltestengine.XslTestEngine;

public class XslTestEngineTest
{

    private static File rootFolder;

    @BeforeClass
    public static void init()
    {
        URL rootFolderUrl = ClassLoader.getSystemResource("xsltestengine");

        try
        {
            rootFolder = new File(rootFolderUrl.toURI());
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void basicDocumentSourceTest()
    {

        DocumentSource docSource = getDocumentSource();
        List<DocumentId> documentIds = docSource.getDocumentIds();

        assertNotNull("documentIds cannot be null", documentIds);
        assertTrue("There must be at least one file in " + rootFolder, documentIds.size() > 0);

        for (DocumentId id : documentIds)
        {
            System.out.println(id);
        }

    }

    @Test
    public void basicXslTestEngine()
    {

        XslTestEngine engine = new XslTestEngine(getDocumentSource(), getXslOutputValidation());

        // TODO return a list of runReport or something similar?
        int run = engine.run();

        assertNotNull(run);
        
        System.err.println(run);

    }

    public DocumentSource getDocumentSource()
    {
        // Create a new DocumentSource
        return new FolderDocumentSource(rootFolder, new String[] { "xml" }, true);

    }

    public XslOutputValidation getXslOutputValidation()
    {

        URL xslUrl = ClassLoader.getSystemResource("xsltestengine/toHtmlWithIds.xsl");
        XslScenario scenario = new XslScenario(xslUrl);

        List<OutputValidator> outputValidators = new ArrayList<OutputValidator>();
        outputValidators.add(new AlwaysTrueValidator());
        outputValidators.add(new AlwaysFalseValidator());

        XslOutputValidation outputValidation = new JavaXslOutputValidation(scenario, outputValidators);

        return outputValidation;
    }

}