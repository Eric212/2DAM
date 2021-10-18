<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
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
                        <xsl:for-each select="receta/preparacion">
                            <tr>
                                <xsl:if test="@dificultad='facil' or @dificultad='media'"><td><xsl:value-of select="../nombre"></xsl:value-of></td></xsl:if>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>