<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="recetas">
        <html>
            <head>
                <meta charset="UTF-8"></meta>
                <link href="normalize.css" type="text/css" rel="stylesheet"></link>
                <link href="Recetas.css" type="text/css" rel="stylesheet"></link>
            </head>
            <body>
                <div id="backtable">
                    <h2>Recetas</h2>
                    <table border="1px">
                        <xsl:for-each select="receta">
                            <tr>
                               <td colspan="2"><h4><xsl:value-of select="nombre"></xsl:value-of></h4></td>
                            </tr>
                            <xsl:for-each select="ingrediente">
                            <tr>
                                <td><p><xsl:value-of select="*"></xsl:value-of></p><xsl:value-of select="cantidad"></xsl:value-of><xsl:value-of select="cantidad/@medida"></xsl:value-of></td>
                            </tr>
                            </xsl:for-each>
                        </xsl:for-each>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>