<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"  indent="yes"/>
<xsl:template match="/museos">
  <museos>
	<xsl:copy-of select="contenidoRelleno" />
	<xsl:apply-templates select="museo"/>
  </museos>
</xsl:template>

<xsl:template match="museo">
<museo ubicacion="{ciudad} ({pais})">
	<xsl:value-of select="nombre" />
</museo>
</xsl:template>
</xsl:stylesheet>