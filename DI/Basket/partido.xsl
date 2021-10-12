<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="partido">
        <html>
            <head>
                <title>Lakers vs Celtics</title>
                <link href="normalize.css" type="text/css" rel="stylesheet"></link>
                <link href="css.css" type="text/css" rel="stylesheet"></link>
            </head>
            <body>
                <div id="backlakers">
                    <img src="lakers.png"></img>
                    <table id="lakers">
                        <th colspan="4"><xsl:value-of select="equipo[1]/nombre[1]"></xsl:value-of></th>
                        <xsl:for-each select="equipo[1]/jugador">
                        <tr>
                            <td><xsl:value-of select="nombre"></xsl:value-of></td>
                            <xsl:choose>
                                <xsl:when test="@titular='true'">
                                    <td id="titular_check"></td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td id="titular_uncheck"></td>
                                </xsl:otherwise>
                            </xsl:choose>
                            <td><xsl:value-of select="dorsal"></xsl:value-of></td>
                        </tr>
                        </xsl:for-each>
                    </table>
                </div>
                <div id="backceltics">
                    <img src="celtic.png"></img>
                    <table id="celtics">
                        <th colspan="4"><xsl:value-of select="equipo[2]/nombre[1]"></xsl:value-of></th>
                        <xsl:for-each select="equipo[2]/jugador">
                            <tr>
                                <td><xsl:value-of select="nombre"></xsl:value-of></td>
                                <xsl:choose>
                                    <xsl:when test="@titular='true'">
                                        <td id="titular_check"></td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td id="titular_uncheck"></td>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <td><xsl:value-of select="dorsal"></xsl:value-of></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
                <div id="backanotaciones">
                    <table id="anotaciones">
                        <th colspan="4">Anotaciones</th>
                        <tr>
                            <td>Equipo</td>
                            <td>Jugador</td>
                            <td>Dorsal</td>
                            <td>Puntos</td>
                        </tr>
                        <xsl:for-each select="destacados/anotacion">
                            <tr>
                                <td><xsl:value-of select="equipo"></xsl:value-of></td>
                                <td><xsl:value-of select="nombre_jugador"></xsl:value-of></td>
                                <td><xsl:value-of select="dorsal"></xsl:value-of></td>
                                <td><xsl:value-of select="puntuacion"></xsl:value-of></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
                <div id="backmarcador">
                    <table id="marcador">
                        <tr>
                            <td><xsl:value-of select="sum(destacados/anotacion[equipo='Boston Celtics']/puntuacion)"></xsl:value-of></td>
                            <td><xsl:value-of select="sum(destacados/anotacion[equipo='Los Angeles Lakers']/puntuacion)"></xsl:value-of></td>
                        </tr>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>