<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <link href="style.css" rel="stylesheet" type="text/css"/>
            </head>
            <body>
                <div id="banner">
                    <h1 id="Inicio">El BiteCode</h1>
                    <hr/>
                </div>
                <table id="menu">
                    <th>
                        <h3>Menu</h3>
                    </th>
                    <xsl:for-each select="RESTAURANTE/MENU">
                    <tr>
                        <td>
                            <xsl:value-of select="PRIMERO"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="SEGUNDO"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="TERCERO"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="POSTRE"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="CAFE"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="PRECIO_MENU"/>
                        </td>
                    </tr>
                        </xsl:for-each>
                </table>
                <table id="carta">
                    <th>
                        <h3>Carta</h3>
                    </th>
                    <xsl:for-each select="RESTAURANTE/CARTA/PLATO_CARTA">
                    <tr>
                        <td>
                            <xsl:value-of select="NOMBRE_PLATO"/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="PRECIO_PLATO"/><br/>
                        </td>
                    </tr>
                    </xsl:for-each>
                </table>
                <table id="personal">
                    <th>
                        <h3>Personal</h3>
                    </th>
                    <xsl:for-each select="RESTAURANTE/PLANTILLA/EMPLEADO">
                        <tr>
                            <td><xsl:value-of select="NOMBRE_EMPLEADO"/></td>
                            <td><xsl:value-of select="@CARGO"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>