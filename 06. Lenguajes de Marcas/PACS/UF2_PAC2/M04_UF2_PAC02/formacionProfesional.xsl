<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" version="4.0" encoding="UTF-8" indent="no"/>
<xsl:variable name="newline">
  <xsl:text>&#xA;</xsl:text>
  </xsl:variable>
<xsl:template match="/">
  
    <xsl:for-each select="fp/modulos/modulo">
		<xsl:text>Módulo: </xsl:text>
		<xsl:value-of select="nombre"/>
		<xsl:text> (</xsl:text>
		<xsl:value-of select="duracion"/>
		<xsl:text> </xsl:text>
		<xsl:value-of select="duracion/@unidad"/>
		<xsl:text> semanales)</xsl:text>
		<xsl:value-of select="$newline"/>
    </xsl:for-each>
</xsl:template>

</xsl:stylesheet>